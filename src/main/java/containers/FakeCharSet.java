package containers;

import models.FakeChar;
import models.SubstantialChar;

import java.util.*;

public class FakeCharSet implements CharSet{

    final private static double mCountSurchargeFactor = 1.5;

    // final private Map<Long, FakeChar> mFakeCharSet = new HashMap<>(); TODO : delete
    final private List<FakeChar> mFakeCharList = new ArrayList<>();

    @Override
    public String getEncoded(Character aChar) {
        if (mFakeCharList.size() > 0){
            return mFakeCharList.remove(0).encode();
        }
        return null;
    }

    @Override
    public Character getDecoded(String aEncoded) {
        return null;
    }

    public void fillFromSubstantialCharSet(final Set<Map.Entry<Character, SubstantialChar>> aSubstantialCharSet){
        /* TODO delete
        for (Map.Entry<Character, SubstantialChar> substantial : aSubstantialCharSet){
            mFakeCharSet.put(substantial.getKey(), new FakeChar(substantial.getValue()));
        }
        */
        for (Map.Entry<Character, SubstantialChar> substantial : aSubstantialCharSet){
            long surchargedCount = (long) (((double) substantial.getValue().getCount()) * mCountSurchargeFactor);
            for (int i=0; i<surchargedCount; i++){
                mFakeCharList.add(new FakeChar(substantial.getValue()));
            }
        }
        Collections.shuffle(mFakeCharList);
    }
}