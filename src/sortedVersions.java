import java.util.Arrays;
import java.util.Comparator;

public class sortedVersions {
    public int comparator(String a, String b) {
        String[] sa = a.split(".");
        String[] sb = b.split(".");

        if (sa.length != sb.length) {
            if (sa.length > sb.length)
                return 0;
            return 1;
        }

        for (int i = 0; i < sa.length; i++) {
            if (Integer.valueOf(sa[i]) < Integer.valueOf(sb[i])) {
                return 0;
            }
            if (Integer.valueOf(sa[i]) > Integer.valueOf(sb[i])) {
                return 1;
            }
        }
        return 0;
    }

    public String[] sort(String[] list) {
        //example
        //String[] list = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        String[] sorted = Arrays.stream(list).sorted(
                new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        String[] sa = a.split("\\.");
                        String[] sb = b.split("\\.");

                        int length = Math.min(sa.length, sb.length);

                        for (int i = 0; i < length; i++) {
                            int comp = Integer.valueOf(sa[i]).compareTo(Integer.valueOf(sb[i]));
                            if (comp != 0) {
                                return comp;
                            }
                        }
                        return ((Integer) sa.length).compareTo(sb.length);
                    }
                }
        ).toArray(String[]::new);

        return sorted;
    }
}
