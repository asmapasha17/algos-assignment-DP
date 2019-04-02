/**
 * Glass Falling
 */
public class GlassFalling {
    // Do not change the parameters!
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int glassFallingRecur(int floors, int sheets) {
        if (floors == 1 || floors == 0)
            return floors;
        if (sheets == 1)
            return floors;

        int min = Integer.MAX_VALUE, x, res;
        for (x = 1; x <= floors; x++) {
            res = max(glassFallingRecur(x - 1, sheets - 1), glassFallingRecur(floors - x, sheets));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    public int glassFallingMemoized(int floors, int sheets) {
        int[][] glassFloor = new int[sheets + 1][];
        for (int p = 0; p <= sheets; p++) {
            glassFloor[p] = new int[floors + 1];
        }
        int res;
        int i, j, x;
        for (i = 1; i <= sheets; i++) {
            glassFloor[i][1] = 1;
            glassFloor[i][0] = 0;
        }
        for (j = 1; j <= floors; j++)
            glassFloor[1][j] = j;
        for (i = 2; i <= sheets; i++) {
            for (j = 2; j <= floors; j++) {
                glassFloor[i][j] = Integer.MAX_VALUE;


                for (x = 1; x <= j; x++) {
                    res = 1 + max(glassFloor[i - 1][x - 1], glassFloor[i][j - x]);
                    if (res < glassFloor[i][j])
                        glassFloor[i][j] = res;
                }
            }
        }
        return glassFloor[sheets][floors];
    }

    // Do not change the parameters!
    public int glassFallingBottomUp(int floors, int sheets) {

        int[][] glassFloor = new int[sheets + 1][];
        for (int p = 0; p <= sheets; p++) {
            glassFloor[p] = new int[floors + 1];
        }
        int res;
        int i, j, x;
        for (i = 1; i <= sheets; i++) {
            glassFloor[i][1] = 1;
            glassFloor[i][0] = 0;
        }
        for (j = 1; j <= floors; j++)
            glassFloor[1][j] = j;
        for (i = 2; i <= sheets; i++) {
            for (j = 2; j <= floors; j++) {
                glassFloor[i][j] = Integer.MAX_VALUE;


                for (x = 1; x <= j; x++) {
                    res = 1 + max(glassFloor[i - 1][x - 1], glassFloor[i][j - x]);
                    if (res < glassFloor[i][j])
                        glassFloor[i][j] = res;
                }
            }
        }
        return glassFloor[sheets][floors];
    }

    public static void main(String args[]) {
        GlassFalling gf = new GlassFalling();
        // Do not touch the below lines of code, and make sure
        // in your final turned-in copy, these are the only things printed
        int minTrials1Recur = gf.glassFallingRecur(27, 2);
        int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
        int minTrials2Memoized = gf.glassFallingMemoized(100, 3);
        int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
        System.out.println(minTrials1Recur + " " + minTrials1Bottom);
        System.out.println(minTrials2Memoized + " " + minTrials2Bottom);

    }
}
