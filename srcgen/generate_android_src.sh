#!/bin/bash

CLASSPATH=${ANDROID_HOST_OUT}/framework/currysrc.jar:${ANDROID_HOST_OUT}/framework/android_bouncycastle_srcgen.jar
BOUNCY_CASTLE_DIR=${ANDROID_BUILD_TOP}/external/bouncycastle

cd ${ANDROID_BUILD_TOP}
make -j15 android_bouncycastle_srcgen

function do_transform() {
  SRC_IN_DIR=$1
  SRC_OUT_DIR=$2

  if [ ! -d $SRC_OUT_DIR ]; then
    echo ${SRC_OUT_DIR} does not exist >&2
    exit 1
  fi
  rm -rf ${SRC_OUT_DIR}
  mkdir -p ${SRC_OUT_DIR}

  java -cp ${CLASSPATH} com.android.bouncycastle.srcgen.BouncyCastleTransform ${SRC_IN_DIR} ${SRC_OUT_DIR}
}

BCPROV_SRC_IN_DIR=${BOUNCY_CASTLE_DIR}/bcprov/src/main/java
BCPROV_SRC_OUT_DIR=${BOUNCY_CASTLE_DIR}/android_bcprov/src/main/java
do_transform ${BCPROV_SRC_IN_DIR} ${BCPROV_SRC_OUT_DIR}

BCPKIX_SRC_IN_DIR=${BOUNCY_CASTLE_DIR}/bcpkix/src/main/java
BCPKIX_SRC_OUT_DIR=${BOUNCY_CASTLE_DIR}/android_bcpkix/src/main/java
do_transform ${BCPKIX_SRC_IN_DIR} ${BCPKIX_SRC_OUT_DIR}

