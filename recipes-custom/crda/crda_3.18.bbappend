# Patch to forcibly map the US wireless regulatory domain to a custom one.
# This becomes handy when the NIC is hardcoded to use the US regulatory domain.

__CRDA_FORCED_COUNTRY = "ES"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

do_configure_prepend() {
    cd ${WORKDIR}/wireless-regdb-2014.11.18
    gawk -i inplace 'BEGIN{cnt=0;flag2=0} /country ${__CRDA_FORCED_COUNTRY}:/{flag1=1;flag2=0;print $0;next} {if(flag1 && !flag2){arr[cnt]=$0;cnt++} if(!flag2){print $0}} /^$/{flag1=0;flag2=0} /country US:/{flag2=1;for(i in arr){print arr[i]}next}' db.txt
    oe_runmake
    cd -
    cp -v ${WORKDIR}/wireless-regdb-2014.11.18/*.key.pub.pem ${WORKDIR}/crda-3.18/pubkeys/
}
