#
# r8168
#

DESCRIPTION = "r8168"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=958e262e6c9b574058c2e38d52ed03c5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "git://github.com/serede/r8168.git"
SRCREV = "2dc3c8b3d70cd5f24a1a8f7a4681122d7c195f94"

S = "${WORKDIR}/git"

inherit module

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""

KERNEL_MODULE_AUTOLOAD += "r8168"
