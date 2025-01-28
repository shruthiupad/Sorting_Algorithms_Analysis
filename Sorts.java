public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.length - 1; outer++){
            for (int inner = 0; inner < list.length-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list[inner]>(list[inner + 1])){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        int n = list.length;
        steps = 0;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = list[i];
            list[i] = list[min_idx];
            list[min_idx] = temp;           
        }
      
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int key = list[i];
            int j = i - 1;

            /* Move elements of list[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }

     /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void mergeSort(int [] list, int n){
        //replace these lines with your code
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = list[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = list[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(list, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
      int i = 0, j = 0, k = 0;
      while (i < left && j < right) {
        if (l[i] <= r[j])
        {
          a[k++] = l[i++];
        }
        else
        {
          a[k++] = r[j++];
        }
      }
        
      while (i < left)
      {
        a[k++] = l[i++];
      }
      while (j < right)
      {
        a[k++] = r[j++];
      }
    }    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
