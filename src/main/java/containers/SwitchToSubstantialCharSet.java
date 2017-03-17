package containers;

import models.SubstantialChar;

import java.util.HashMap;
import java.util.Map;

public class SwitchToSubstantialCharSet implements CharSet{

    final private Map<Character, SubstantialChar> mSwitchToSubstantialCharSet = new HashMap<>();

    @Override
    public String getEncoded(Character aChar) {
        if (!mSwitchToSubstantialCharSet.containsKey(aChar)){
            mSwitchToSubstantialCharSet.get(aChar).encode();
        }
        return mSwitchToSubstantialCharSet.get(aChar).encode();
    }

    @Override
    public Character getDecoded(String aEncoded) {
        return null;
    }
}