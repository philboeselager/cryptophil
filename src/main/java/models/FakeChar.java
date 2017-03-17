package models;

import java.util.Random;

/**
 * Created by boeselager on 17.03.17.
 */
public class FakeChar implements CryptoChar {

    final private char mDecoded;
    final private String mEncoded;
    private long mCount = 0;
    private long mTargetCount = 0;

    final private static double mCountTolerance = (new Random().nextDouble() - 0.5) / 5.0 + 1.0;

    public FakeChar(final SubstantialChar aSubstantialChar){
        mDecoded = aSubstantialChar.decode();
        mEncoded = aSubstantialChar.encode();
        mTargetCount = (long) (((double) aSubstantialChar.getCount()) * mCountTolerance);
    }

    public void incrementCount(){
        mCount++;
    }

    @Override
    public String encode() {
        return null;
    }

    @Override
    public Character decode() {
        return null;
    }
}
