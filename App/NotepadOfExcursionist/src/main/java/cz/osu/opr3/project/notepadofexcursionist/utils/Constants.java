package cz.osu.opr3.project.notepadofexcursionist.utils;

public class Constants {

    public static final String PERSISTENCE_NAME = "namePU";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String DATE_FORMAT_PATTERN = "d.M.yyyy";
    public static final String DATE_FORMAT_PATTERN_DEFAULT = "yyyy-MM-dd";
    public static final String TIME_FORMAT_PATTERN = "h:mm:ss";
    public static final String DEFAULT_USER_PICTURE_BASE64_STRING = getDefaultUserPicture();
    public static final String TRIP_PLACE_STRING_SEPARATOR = ",";
    //TODO change pass pattern to -> ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,16}$
    public static final String VALID_PASSWORD_PATTERN = "^[a-zA-Z]$";
    public static final String VALID_EMAIL_PATTERN = "^[a-zA-Z0-9.]{1,64}@[a-zA-Z]{1,20}.[a-zA-Z0-9]{2,5}$";

    private static String getDefaultUserPicture() {
        return "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAKlBMVEXc3Nz" +
                "////t7e37+/ve3t7l5eXh4eH4+Pjm5uby8vL19fXv7+/p6ena2tpwjZMDAAAEq0lEQVR4nO2d0XajMAxEARswhv7" +
                "/765JmjYNIYnlAUas7p597xzJ8kg2TlUZhmEYhmEYhmEYhmEYhmEYhmEYhmEYhgp8+nda/EzopqP/" +
                "jm1JITxxDL85v0LDMAzDMAzjHd38f2qGIcZhbKa27c7lErshhFhfcMOYFIak8EwSx7p39SOuH5pwjkh2/" +
                "ULdnc7YtNpVdi/0fRMnzSL9e4Ezg958HT5TeNGoU+SnAhOjPok+NB+HcMa1ujS2MUfdlUmRxE6gr9aUqY1InyKJo1Sg" +
                "FoldkCvUsRY/8DEv0GDjZFXmRs/vb9oigWkp0kssC2HNn6cfmu0XsPvw0iRNBG6F07KhzyVyB/FlU3+KIJavQ/aVCFiHc" +
                "yN1tIwXiF33PQ1zELO63jWoaw2g0KQ0Za41CIHcaYpRSFxNEZtFouetpiCFxAsRpLCeaNMUpZC31KAUEvfBIIXExRSlkLe" +
                "YlreH7Aohro1aIcR5UyuEdE+plvIqLBnp61BYNtP/gXfHrzymmPK6tsoXz7xnHLHCktPDX3re3gIzbKsjb6EBLUTiUloBDp9" +
                "q6lJaQfZ8R31vsQUo7GPDe54P6i3qyCoRZEtr3gMoyH5/gbXYgNrD/0EhrW+DKRxOvw5p77hDfHfNvOdDfHcisiYpbF5KbL1" +
                "BWz7rXpF6J9CchnWvSHjIwJS30FSgcSL1FAOSpsQj75SmCFtDu99fAGz6tKb0CmDTj6E7WsUrAMM24v3+QnGakicpoJoO3Elal" +
                "Z+STuRJWrwSR/oQVr7ta6FIF93A7Nhu+C4IMzVqeXHBe6E9HdW8t+CF17/4i8wvIntK3TU9Imr2icczS0T7Prtd+4Oki6K3a38Rp" +
                "KmqJBWlKXfjuyS7x1CWpIIg0p7GrJE7WFQXwuwgqgthlXvWpsmx3chK016TY7uRVU2Jv3VaJ0sh9W29NbIUUk/y1zi/wqxKc36FKtd" +
                "hVgOlspbmjRR5z+7XyRJI/hn+E77a7C7fBSWjxAuyDy8USZSek6p4zmxGfnFISQtVcDOK++mWb74muUAVL7ZVRQIVRNGXXzdhtqhfvo" +
                "F8cdE3HefP+3SoO8KzSMJnsAPuW4QrXNkKSs8HXMNyJtyCvsN/AsEYNVUXdHr+JQXyUIGSh62zOW4A0I1brL5nuCMaZD9tm52P7Fxa/" +
                "bRHdj7Q77cipXeeyhna7X/M0IcDondHv22XfEhyLtjuoazjkvORbX68BfBGMBA3oqvOJr6zjBg8bkkW9u1b4VBVB/HC80ZgBuW4dwQ2" +
                "AHGiw7A/vMCVRhH08tOGFM4f+QWWGgDyFL1ScqBDXWR+KMhT0IfLmyO/9KciR+uCIGoJoTyINK3EW6TW5ui/OwPZVBX0VOcuyPZEPUkqt" +
                "acK7MwvkjTVU0lnJBNj1HM6+yCppjoc2w3J8b+mQpMQfCDNO7p4Sv5C1NAZ3pO/I+oqpZKjKV2lVHKKqsmzzeQrJB0Cr5KvUNd2KHGm51c" +
                "IvMG1C6ZwiTLTZgqfoGWSeMMUmkJ+8hUqaw8Fru30CiHPdO6JKTSF/GRPMUwhHaZwiSlk4/wK8x/sM4VsZJ9bqKul+Scz51c4OF28+WKoX" +
                "RKmRhfhiYgf/gHZ+1ogqTKAlQAAAABJRU5ErkJggg==";
    }

}
