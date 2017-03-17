package containers;

import models.SubstantialChar;

import java.util.HashMap;
import java.util.Map;

public class SwitchToFakeCharSet implements CharSet{

    final private Map<Character, SubstantialChar> mSwitchToFakeCharSet = new HashMap<>();

    @Override
    public String getEncoded(Character aChar) {
        if (!mSwitchToFakeCharSet.containsKey(aChar)){
            mSwitchToFakeCharSet.get(aChar).encode();
        }
        return mSwitchToFakeCharSet.get(aChar).encode();
    }

    @Override
    public Character getDecoded(String aEncoded) {
        return null;
    }
}