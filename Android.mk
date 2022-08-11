#
# Copyright (C) 2010 The Android Open Source Project
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
#
LOCAL_PATH := $(call my-dir)

# All the files needed for OCSP testing
all_bc_ocsp_files := $(call all-java-files-under,bcpkix/src/main/java/org/bouncycastle/cert/ocsp) \
 $(call all-java-files-under,bcprov/src/main/java/org/bouncycastle/asn1/ocsp)

# used for bouncycastle-hostdex where we want everything for testing
all_bcprov_src_files := $(filter-out \
 $(all_bc_ocsp_files), \
 $(call all-java-files-under,bcprov/src/main/java))

# used for bouncycastle for target where we want to be sure to use OpenSSLDigest
android_bcprov_src_files := $(filter-out \
 bcprov/src/main/java/org/bouncycastle/crypto/digests/AndroidDigestFactoryBouncyCastle.java, \
 $(all_bcprov_src_files))

# used for bouncycastle-host where we can't use OpenSSLDigest
ri_bcprov_src_files := $(filter-out \
 bcprov/src/main/java/org/bouncycastle/crypto/digests/AndroidDigestFactoryOpenSSL.java \
 bcprov/src/main/java/org/bouncycastle/crypto/digests/OpenSSLDigest.java, \
 $(all_bcprov_src_files))

# used for host tools, but OCSP is only for testing
all_bcpkix_src_files := $(filter-out \
 $(all_bc_ocsp_files), \
 $(call all-java-files-under,bcpkix/src/main/java))

# These cannot build in the PDK, because the PDK requires all libraries
# compile against SDK versions. LOCAL_NO_STANDARD_LIBRARIES conflicts with
# this requirement.
ifneq ($(TARGET_BUILD_PDK),true)

    # non-jarjar version to build okhttp-tests
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 1)
    LOCAL_MODULE := bouncycastle
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(android_bcprov_src_files)
    LOCAL_NO_STANDARD_LIBRARIES := true
    LOCAL_JAVA_LANGUAGE_VERSION := 1.7
    include $(BUILD_STATIC_JAVA_LIBRARY)

    # unbundled bouncycastle jar
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 4)
    LOCAL_MODULE := bouncycastle-unbundled
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(filter-out \
        $(call all-java-files-under,bcprov/src/main/java/org/bouncycastle/asn1/ocsp), \
        $(call all-java-files-under,bcprov/src/main/java))
    LOCAL_JAVA_LANGUAGE_VERSION := 1.7
    include $(BUILD_STATIC_JAVA_LIBRARY)

    # PKIX classes used for testing
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 5)
    LOCAL_MODULE := bouncycastle-bcpkix-nojarjar
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(all_bcpkix_src_files)
    LOCAL_NO_STANDARD_LIBRARIES := true
    LOCAL_JAVA_LIBRARIES := bouncycastle
    include $(BUILD_STATIC_JAVA_LIBRARY)

    # OCSP classes used for testing
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 7)
    LOCAL_MODULE := bouncycastle-ocsp
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(all_bc_ocsp_files)
    LOCAL_JAVA_LIBRARIES := bouncycastle bouncycastle-bcpkix-nojarjar
    LOCAL_JARJAR_RULES := $(LOCAL_PATH)/jarjar-rules.txt
    LOCAL_JAVA_LANGUAGE_VERSION := 1.7
    LOCAL_NO_STANDARD_LIBRARIES := true
    include $(BUILD_STATIC_JAVA_LIBRARY)
endif # TARGET_BUILD_PDK != true

# Conscrypt isn't built in the PDK or on non-linux OSes, so this cannot be built
# because it has a dependency on conscrypt-hostdex.
ifneq ($(TARGET_BUILD_PDK),true)
  ifeq ($(HOST_OS),linux)
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 8)
    LOCAL_MODULE := bouncycastle-hostdex-nojarjar
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(all_bcprov_src_files)
    LOCAL_JAVA_LIBRARIES := conscrypt-hostdex
    include $(BUILD_HOST_DALVIK_STATIC_JAVA_LIBRARY)

    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 9)
    LOCAL_MODULE := bouncycastle-hostdex
    LOCAL_MODULE_TAGS := optional
    LOCAL_STATIC_JAVA_LIBRARIES := bouncycastle-hostdex-nojarjar
    LOCAL_JAVA_LIBRARIES := conscrypt-hostdex
    LOCAL_JARJAR_RULES := $(LOCAL_PATH)/jarjar-rules.txt
    LOCAL_JAVA_LANGUAGE_VERSION := 1.7
    include $(BUILD_HOST_DALVIK_JAVA_LIBRARY)

    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 10)
    LOCAL_MODULE := bouncycastle-bcpkix-hostdex-nojarjar
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(all_bcpkix_src_files)
    LOCAL_STATIC_JAVA_LIBRARIES := bouncycastle-hostdex-nojarjar
    include $(BUILD_HOST_DALVIK_STATIC_JAVA_LIBRARY)

    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 11)
    LOCAL_MODULE := bouncycastle-bcpkix-hostdex
    LOCAL_MODULE_TAGS := optional
    LOCAL_STATIC_JAVA_LIBRARIES := bouncycastle-bcpkix-hostdex-nojarjar
    LOCAL_STATIC_JAVA_LIBRARIES := bouncycastle-hostdex-nojarjar
    LOCAL_JARJAR_RULES := $(LOCAL_PATH)/jarjar-rules.txt
    include $(BUILD_HOST_DALVIK_STATIC_JAVA_LIBRARY)

    # OCSP classes used for testing
    include $(CLEAR_VARS)
    $(info *my flag* bouncycastle 12)
    LOCAL_MODULE := bouncycastle-ocsp-hostdex
    LOCAL_MODULE_TAGS := optional
    LOCAL_SRC_FILES := $(all_bc_ocsp_files)
    LOCAL_STATIC_JAVA_LIBRARIES := bouncycastle-hostdex-nojarjar bouncycastle-bcpkix-hostdex-nojarjar
    LOCAL_JARJAR_RULES := $(LOCAL_PATH)/jarjar-rules.txt
    include $(BUILD_HOST_DALVIK_STATIC_JAVA_LIBRARY)
  endif  # ($(HOST_OS),linux)
endif

include $(CLEAR_VARS)
$(info *my flag* bouncycastle 13)
# LOCAL_SDK_VERSION := 9
LOCAL_MODULE := bouncycastle-host
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(filter-out \
    $(call all-java-files-under,bcprov/src/main/java/org/bouncycastle/asn1/ocsp), \
    $(call all-java-files-under,bcprov/src/main/java))
LOCAL_JAVA_LANGUAGE_VERSION := 1.7
LOCAL_JAVA_LANGUAGE_VERSION := 1.7
include $(BUILD_HOST_JAVA_LIBRARY)

include $(CLEAR_VARS)
$(info *my flag* bouncycastle 14)
# LOCAL_SDK_VERSION := 9
LOCAL_MODULE := bouncycastle-bcpkix-host
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(all_bcpkix_src_files)
LOCAL_JAVA_LIBRARIES := bouncycastle-host
LOCAL_JAVA_LANGUAGE_VERSION := 1.7
include $(BUILD_HOST_JAVA_LIBRARY)

# OCSP classes used for testing
include $(CLEAR_VARS)
$(info *my flag* bouncycastle 15)
# LOCAL_SDK_VERSION := 9
LOCAL_MODULE := bouncycastle-ocsp-host
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(all_bc_ocsp_files)
LOCAL_JAVA_LIBRARIES := bouncycastle-host bouncycastle-bcpkix-host
include $(BUILD_HOST_JAVA_LIBRARY)

# Unset these so they don't linger in the next makefile
all_bcprov_src_files :=
android_bcprov_src_files :=
ri_bcprov_src_files :=
all_bcpkix_src_files :=
all_bc_ocsp_files :=
