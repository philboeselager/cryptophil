package transformers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by philboeselager on 14.11.16.
 */
public class EncryptorSettings {

    private Set<Character> mEncodingChars;
    private short mEncodingLength;

    public EncryptorSettings(){
        mEncodingChars = new HashSet<>();
        mEncodingChars.addAll(
                Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));
        mEncodingLength = 4;
    }

    public Set<Character> getEncodingChars(){
        return mEncodingChars;
    }

    public short getEncodingLength() {
        return mEncodingLength;
    }

    public void setEncodingLength(final short aLength){
        if (aLength < 3){
            throw new IllegalArgumentException("EncryptorSettings.mEncodingLength must be 3 or greater.");
        }
    }
}
