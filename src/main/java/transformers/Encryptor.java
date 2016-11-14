package transformers;

import containers.SubstantialCharSet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by philboeselager on 14.11.16.
 */
public class Encryptor{

    SubstantialCharSet mSubstantialChars;

    public Encryptor(){

    }

    public Encryptor(EncryptorSettings aSettings){
        mSubstantialChars = new SubstantialCharSet(aSettings.getEncodingLength(),
                                                   aSettings.getEncodingChars());
    }

    public String encode(String aUnencoded){
        StringBuffer encoded = new StringBuffer();
        aUnencoded.chars().forEachOrdered(x -> encoded.append(mSubstantialChars.getEncoded((char) x)));
        return encoded.toString();
    }

    public String fillEncoded(String aEncoded){
        // TODO
        return null;
    }

    public String unfillEncoded(String aEncoded){
        // TODO
        return null;
    }

    public String decode(String aEncoded){
        StringBuffer decoded = new StringBuffer();
        StringBuffer innerBuffer = new StringBuffer();
        final AtomicInteger count = new AtomicInteger();
        short limit = mSubstantialChars.getEncodedLength();
        aEncoded.chars().forEachOrdered(x -> {
            innerBuffer.append((char) x);
            if (count.incrementAndGet() == limit){
                decoded.append(mSubstantialChars.getDecoded(innerBuffer.toString()));
                count.set(0);
            }
        });
        return decoded.toString();
    }

}