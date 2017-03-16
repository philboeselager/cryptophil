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
    final private Map<String, SubstantialChar> mDecodingCharSet = new HashMap<>();

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
        SubstantialChar sc = new SubstantialChar(aChar, mEncodedLength, mEncodedFactory);
        mEncodingCharSet.put(aChar, sc);
        mDecodingCharSet.put(sc.getEncoded(), sc);
    }

    @Override
    public String getEncoded(Character aChar){
        return mEncodingCharSet.get(aChar).getEncoded();
    }

    @Override
    public Character getDecoded(String aEncoded){
        return mDecodingCharSet.get(aEncoded).getDecoded();
    }

    public short getEncodedLength() {
        return mEncodedLength;
    }
}
