#
# aria2
#

DESCRIPTION = "aria2"
SECTION = "network"
DEPENDS = "libxml2 zlib nettle sqlite3 gnutls gmp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "36902526b66907f1f4b0add9900d8a82521b45d4"
SRC_URI = "git://github.com/aria2/aria2.git"

S = "${WORKDIR}/git"

inherit autotools gettext pkgconfig

do_configure_prepend() {
	touch "${S}/ABOUT-NLS"
}

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""

