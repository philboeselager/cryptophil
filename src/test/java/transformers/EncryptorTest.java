package transformers;

import containers.SubstantialCharSetTest;
import helpers.FileHelpers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by philboeselager on 14.11.16.
 */
public class EncryptorTest {

    private static String mText01;
    private Encryptor mEncryptor = new Encryptor();

    @BeforeClass
    public static void loadResources() throws IOException {
        mText01 = FileHelpers.fileToString("NordwindUndSonne.txt",
                Charset.forName("UTF-8"),
                SubstantialCharSetTest.class);
    }

    @Test
    public void testSimpleEncodeAndDecode() throws IOException {
        // encoding
        String encoded = mEncryptor.encode(mText01);
        // decoding
        String unencoded = mEncryptor.decode(encoded);
        // check
        Assert.assertEquals(mText01, unencoded);
    }
}
