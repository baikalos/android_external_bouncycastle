#!/bin/bash
# Copyright (C) 2018 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

if [ -z "$ANDROID_BUILD_TOP" ]; then
    echo "Missing environment variables. Did you run build/envsetup.sh and lunch?" 1>&2
    exit 1
fi

CLASSPATH=${ANDROID_HOST_OUT}/framework/currysrc.jar
BOUNCY_CASTLE_DIR=${ANDROID_BUILD_TOP}/external/bouncycastle

cd ${ANDROID_BUILD_TOP}
make -j15 currysrc

CORE_PLATFORM_API_FILE=${BOUNCY_CASTLE_DIR}/srcgen/core-platform-api.txt
UNSUPPORTED_APP_USAGE_FILE=${BOUNCY_CASTLE_DIR}/srcgen/unsupported-app-usage.json
DEFAULT_CONSTRUCTORS_FILE=${BOUNCY_CASTLE_DIR}/srcgen/default-constructors.txt

function do_transform() {
  local SRC_IN_DIR=$1
  local SRC_OUT_DIR=$2

  if [ ! -d $SRC_OUT_DIR ]; then
    echo ${SRC_OUT_DIR} does not exist >&2
    exit 1
  fi
  rm -rf ${SRC_OUT_DIR}
  mkdir -p ${SRC_OUT_DIR}

  java -cp ${CLASSPATH} com.google.currysrc.aosp.RepackagingTransform \
       --source-dir ${SRC_IN_DIR} \
       --target-dir ${SRC_OUT_DIR} \
       --package-transformation "org.bouncycastle:com.android.org.bouncycastle" \
       --core-platform-api-file ${CORE_PLATFORM_API_FILE} \
       --unsupported-app-usage-file ${UNSUPPORTED_APP_USAGE_FILE} \
       --default-constructors ${DEFAULT_CONSTRUCTORS_FILE} \

}

REPACKAGED_DIR=${BOUNCY_CASTLE_DIR}/repackaged
BCPROV_SRC_IN_DIR=${BOUNCY_CASTLE_DIR}/bcprov/src/main/java
BCPROV_SRC_OUT_DIR=${REPACKAGED_DIR}/bcprov/src/main/java
do_transform ${BCPROV_SRC_IN_DIR} ${BCPROV_SRC_OUT_DIR}

# Remove some unused source files:
rm -fr ${REPACKAGED_DIR}/bcprov/src/main/java/com/android/org/bouncycastle/asn1/ocsp/
