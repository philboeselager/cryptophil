package models;

/**
 * Instances of this class are the "real" ones, the ones that contain the
 * substance of the message.
 *
 * Created by philboeselager on 12.11.16.
 */
public class SubstantialChar implements CryptoChar{

    final private char mDecoded;
    final private String mEncoded;
    private long mCount = 0;

    public SubstantialChar(char aDecoded, short aEncodedLength, EncodedFactory aEncodedFactory){
        mDecoded = aDecoded;
        mEncoded = aEncodedFactory.getNewEncoded(aEncodedLength, this);
    }

    public void incrementCount(){
        mCount++;
    }

    public long getCount(){
        return mCount;
    }

    public String getEncoded(){
        return mEncoded;
    }

    public Character getDecoded(){
        return mDecoded;
    }
}
