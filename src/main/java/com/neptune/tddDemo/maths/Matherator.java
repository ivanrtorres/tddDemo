package com.neptune.tddDemo.maths;

public class Matherator {
    public long add(long... i) {
        long result=i[0];
        for (int aa=1;aa<i.length;aa++){
            result+=i[aa];
        }
        return result;
    }

    public long substract(long... i) {
        long result=i[0];
        for (int aa=1;aa<i.length;aa++){
            result-=i[aa];
        }
        return result;
    }

    public long multiply(long... operators) {
        long result=1;
        for(long operator:operators){
            result*=operator;
        }
        return result;
    }
}
