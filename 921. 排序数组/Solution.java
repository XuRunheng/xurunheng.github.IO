class Solution {
    int INSERTION_SORT_THRESHOLD = 7;
    public int[] sortArray(int[] nums) {
        mergeSort(nums, nums.clone(), 0, nums.length);
        return nums;
    }
    private void insertionSort(int[] nums, int begin, int end) {
        for (int r = begin + 1; r < end; r++) {
            int temp = nums[r];
            int l;
            for (l = r - 1; l >= begin; l--) {
                if (nums[l] > temp) {
                    nums[l + 1] = nums[l];
                } else {
                    break;
                }
            }
            nums[l + 1] = temp;
        }
    }
    private void mergeSort(int[] nums, int[] aux, int begin, int end) {
        if (end - begin <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, begin, end);
            return;
        }
        int mid = (begin + end) >>> 1;
        mergeSort(aux, nums, begin, mid);
        mergeSort(aux, nums, mid, end);
        merge(aux, nums, begin, mid, end);
    }
    private void merge(int[] aux, int[] nums, int begin, int mid, int end) {
        int pa = begin, p1 = begin, p2 = mid;
        while (pa < end) {
            if (p2 == end || (p1 < mid && aux[p1] < aux[p2])) {
                nums[pa++] = aux[p1++];
            } else {
                nums[pa++] = aux[p2++];
            }
        }
    }
}
