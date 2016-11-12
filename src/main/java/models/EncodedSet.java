package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by philboeselager on 12.11.16.
 */
public class EncodedSet {

    final private static Map<String, CryptoChar> mEntries = new HashMap<>();

    private EncodedSet(){
        // no instantiation
    }

    public static boolean hasEntry(String aEncoded){
        return mEntries.get(aEncoded) != null;
    }

    public static void addEntry(String aEncoded, CryptoChar aChar){
        mEntries.put(aEncoded, aChar);
    }

    public static CryptoChar get(String aEncoded){
        return mEntries.get(aEncoded);
    }
}
