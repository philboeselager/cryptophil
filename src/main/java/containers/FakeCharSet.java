package containers;

import models.SubstantialChar;

import java.util.HashMap;
import java.util.Map;

public class FakeCharSet implements CharSet{

    final private Map<Character, SubstantialChar> mFakeCharSet = new HashMap<>();

    @Override
    public String getEncoded(Character aChar) {
        if (!mFakeCharSet.containsKey(aChar)){
            mFakeCharSet.get(aChar).getEncoded();
        }
        return mFakeCharSet.get(aChar).getEncoded();
    }

    @Override
    public Character getDecoded(String aEncoded) {
        return null;
    }
}