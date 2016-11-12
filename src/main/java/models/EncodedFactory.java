package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by philboeselager on 12.11.16.
 */
public class EncodedFactory {

    final private List<Character> mCharSet = new ArrayList<>();
    final private List<String> mEncodeds = new ArrayList<>();
    final private Random mRandom = new Random();

    public EncodedFactory(Set<Character> aCharSet){
        mCharSet.addAll(aCharSet);
    }

    public synchronized String getNewEncoded(final short aLength,
                                             final CryptoChar aCryptoChar){
        String newEncoded = createRandomString(aLength);
        while (EncodedSet.hasEntry(newEncoded)){
            newEncoded = createRandomString(aLength);
        }
        mEncodeds.add(newEncoded);
        EncodedSet.addEntry(newEncoded, aCryptoChar);
        return newEncoded;
    }

    // deviated from http://stackoverflow.com/a/5683375 - Thank You! @maerics
    private String createRandomString(final int aLength) {
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<aLength; i++) {
            buf.append(mCharSet.get(mRandom.nextInt(mCharSet.size())));
        }
        return buf.toString();
    }

}
