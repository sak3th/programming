package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Priority {

    public static void main(String[] args) {
        ApnContext a1 = new ApnContext("wifi",1,1);
        ApnContext a2 = new ApnContext("mobile",0,0);
        ApnContext a3 = new ApnContext("mobile_mms",2,2);
        ApnContext a4 = new ApnContext("mobile_supl",3,2);
        ApnContext a5 = new ApnContext("mobile_dun",4,2);
        ApnContext a6 = new ApnContext("mobile_hipri",5,3);
        ApnContext a7 = new ApnContext("mobile_fota",10,2);
        ApnContext a8 = new ApnContext("mobile_ims",11,2);
        ApnContext a9 = new ApnContext("mobile_cbs",12,2);
        ApnContext a10 = new ApnContext("wifi_p2p",13,0);
        ApnContext a11 = new ApnContext("bluetooth",7,0);
        ApnContext a12 = new ApnContext("mobile_ent1",15,2);
        ApnContext a13 = new ApnContext("mobile_ent2",16,2);
        ApnContext a14 = new ApnContext("mobile_bip",23,2);

        /*PriorityQueue<ApnContext> mPrioritySortedApnContexts = new PriorityQueue<ApnContext>(5,
                        new Comparator<ApnContext>() {
                            public int compare(ApnContext c1, ApnContext c2) {
                                return c2.priority - c1.priority;
                            }
                        });*/
        ArrayList<ApnContext> mPrioritySortedApnContexts = new ArrayList<ApnContext>();
        mPrioritySortedApnContexts.add(a1);
        mPrioritySortedApnContexts.add(a2);
        mPrioritySortedApnContexts.add(a3);
        mPrioritySortedApnContexts.add(a4);
        mPrioritySortedApnContexts.add(a5);
        mPrioritySortedApnContexts.add(a6);
        mPrioritySortedApnContexts.add(a7);
        mPrioritySortedApnContexts.add(a8);
        mPrioritySortedApnContexts.add(a9);
        mPrioritySortedApnContexts.add(a10);
        mPrioritySortedApnContexts.add(a11);
        mPrioritySortedApnContexts.add(a12);
        mPrioritySortedApnContexts.add(a13);
        mPrioritySortedApnContexts.add(a14);
        Collections.sort(mPrioritySortedApnContexts,
                new Comparator<ApnContext>() {
                    public int compare(ApnContext c1, ApnContext c2) {
                        return c2.priority - c1.priority;
                    }
                });

        for(ApnContext ac : mPrioritySortedApnContexts) {
            System.out.println(ac);
        }


    }

    private static class ApnContext /*implements Comparable, Comparator */ {
        String network;
        int type;
        int priority;

        private ApnContext(String network, int type, int priority) {
            this.network = network;
            this.type = type;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return network + " " + priority;
        }

        /*@Override
        public int compareTo(Object o) {
            ApnContext apn = (ApnContext)o;
            return apn.priority - this.priority;
        }

        @Override
        public int compare(Object o1, Object o2) {
            ApnContext c1 = (ApnContext)o1;
            ApnContext c2 = (ApnContext)o2;
            return c2.priority - c1.priority;
        }*/
    }
}
