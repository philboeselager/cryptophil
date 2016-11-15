package transformers;

import containers.SubstantialCharSet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by philboeselager on 14.11.16.
 */
public class Encryptor{

    SubstantialCharSet mSubstantialChars;

    public Encryptor(){
        this(new EncryptorSettings());
    }

    public Encryptor(EncryptorSettings aSettings){
        mSubstantialChars = new SubstantialCharSet(aSettings.getEncodingLength(),
                                                   aSettings.getEncodingChars());
    }

    public String encode(String aUnencoded){
        StringBuffer encoded = new StringBuffer();
        aUnencoded.chars().forEachOrdered(x -> {
            char c = (char) x;
            if(!mSubstantialChars.hasChar(c)){
                mSubstantialChars.addChar(c);
            }
            System.out.print(x + "\t");
            System.out.println(mSubstantialChars.getEncoded(c));
            encoded.append(mSubstantialChars.getEncoded(c));
        });
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
        final AtomicInteger count = new AtomicInteger(0);
        short limit = mSubstantialChars.getEncodedLength();
        aEncoded.chars().forEachOrdered(x -> {
            innerBuffer.append((char) x);
            if (count.incrementAndGet() == limit){
                decoded.append(mSubstantialChars.getDecoded(innerBuffer.toString()));
                count.set(0);
                innerBuffer.delete(0,4);
            }
        });
        return decoded.toString();
    }

}