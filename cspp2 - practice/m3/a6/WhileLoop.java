/**
 * Author : Pranay kumar Y.
 * Date : 29th August, 2018.
 */
public final class WhileLoop {
    /**
     * Constructor.
     */
    private WhileLoop() {
        // Zero Parameter Constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int i = 2;
        final int limit = 10;
        while (i <= limit) {
            System.out.println(i);
            i = i + 2;
        }
        System.out.println("GoodBye!");
    }
}
