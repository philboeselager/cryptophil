package containers;

import models.EncodedFactory;
import models.SubstantialChar;

import java.util.*;

public class SubstantialCharSet implements CharSet{

    final private static short DEFAULT_ENCODED_LENGTH = 4;
    final private static Set<Character> DEFAULT_ENCODING_CHAR_SET = new HashSet<>();
    static {
        DEFAULT_ENCODING_CHAR_SET.addAll(
            Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));
    }

    final private EncodedFactory mEncodedFactory;
    final private short mEncodedLength;
    final private Map<Character, SubstantialChar> mEncodingCharSet = new HashMap<>();

    public SubstantialCharSet(){
        this(DEFAULT_ENCODED_LENGTH, DEFAULT_ENCODING_CHAR_SET);
    }

    public SubstantialCharSet(short aEncodedLength){
        this(aEncodedLength, DEFAULT_ENCODING_CHAR_SET);
    }

    public SubstantialCharSet(short aEncodedLength, Set<Character> aEncodedCharSet) {
        mEncodedLength = aEncodedLength;
        mEncodedFactory = new EncodedFactory(aEncodedCharSet);
    }

    public boolean hasChar(Character aChar){
        return mEncodingCharSet.get(aChar) != null;
    }

    public void addChar(Character aChar){
        mEncodingCharSet.put(aChar, new SubstantialChar(aChar, mEncodedLength, mEncodedFactory));
    }

    public String getEncoded(Character aChar){
        return mEncodingCharSet.get(aChar).getEncoded();
    }

    public Character getDecoded(String aEncoded){
        // TODO
        return null;
    }
}
