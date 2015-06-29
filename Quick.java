//requires StdRandom.shuffle function from library
public class Quick
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a); // shuffle to prevent worst case of quick sort (Ascending or decending order)
        sort(a, 0, a.length() - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return; // don't sort equal keys
        int j = partition(a, lo, hi); // put element in position j where it's finally meant to be
        sort(a, lo, j - 1);  //sort left
        sort(a, j + 1, hi);  // sort right
    }
    
    private static int partition(Comparable[] a, lo, hi)
    {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while(true)
        {
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i>=j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b)
    { return a.compareTo(b) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }

}
        