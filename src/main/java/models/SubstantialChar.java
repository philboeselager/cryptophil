package models;

/**
 * Instances of this class are the "real" ones, the ones that contain the
 * substance of the message.
 *
 * Created by philboeselager on 12.11.16.
 */
public class SubstantialChar implements CryptoChar{

    final private char mReal;
    final private String mEncoded;
    private long mCount = 0;

    public SubstantialChar(char aReal, short aEncodedLength, EncodedFactory aEncodedFactory){
        mReal = aReal;
        mEncoded = aEncodedFactory.getNewEncoded(aEncodedLength);
    }

    public void incrementCount(){
        mCount++;
    }

    public long getCount(){
        return mCount;
    }

    public Character getReal(){
        return mReal;
    }

    public String getEncoded(){
        return mEncoded;
    }
}
