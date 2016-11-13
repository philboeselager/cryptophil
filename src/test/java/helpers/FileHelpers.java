package helpers;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by philboeselager on 12.11.16.
 */
public class FileHelpers {

    // from http://stackoverflow.com/a/326440 - Thank you! @erickson
    public static String readFile(String aPath, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(aPath));
        return new String(encoded, encoding);
    }

    public static String fileToString(final String aFileName,
                                      final Charset aCharset,
                                      final Class aClass) throws IOException {
        final InputStream resourceAsStream = aClass.getClassLoader()
                .getResourceAsStream(aFileName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(resourceAsStream, writer, aCharset);
        return writer.toString();
    }
}
