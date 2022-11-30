//Monica Doan
//Coding Dojo Learning Platform Assignment: Implement Quicksort

////////////////////////////////////////////////////////////////////////////////////////////////
//* Objectives:
    //?Technical interview practice
    //? Implement quicksort
    //? Sort an unsorted array with no duplicate values

////////////////////////////////////////////////////////////////////////////////////////////////
	// Javascript implementation of QuickSort

//Hoare's partition scheme
function partition(arr, start, end) {
    // For random pivot use => arr[Math.floor(Math.random() * (end - start + 1) + start)];
    const pivotVal = arr[Math.floor((start + end) / 2)];

    while (start <= end) {
        while (arr[start] < pivotVal) {
            start++;
        }
        while (arr[end] > pivotVal) {
            end--;
        }
        if (start <= end) {
            // swap
            let temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    return start;
}

//quickSort Algorithm
function quickSort(arr, start = 0, end = arr.length - 1) {
    if (start < end) {
        const index = partition(arr, start, end);

        quickSort(arr, start, index - 1);
        quickSort(arr, index, end);
    }

    return arr;
}

//Another version of quickSort

let items = [5,3,7,6,2,9];
function swap(items, leftIndex, rightIndex){
    let temp = items[leftIndex];
    items[leftIndex] = items[rightIndex];
    items[rightIndex] = temp;
}
function partition(items, left, right) {
    let pivot   = items[Math.floor((right + left) / 2)], //middle element
        i       = left, //left pointer
        j       = right; //right pointer
    while (i <= j) {
        while (items[i] < pivot) {
            i++;
        }
        while (items[j] > pivot) {
            j--;
        }
        if (i <= j) {
            swap(items, i, j); //swapping two elements
            i++;
            j--;
        }
    }
    return i;
}

function quickSort(items, left, right) {
    let index;
    if (items.length > 1) {
        index = partition(items, left, right); //index returned from partition
        if (left < index - 1) { //more elements on the left side of the pivot
            quickSort(items, left, index - 1);
        }
        if (index < right) { //more elements on the right side of the pivot
            quickSort(items, index, right);
        }
    }
    return items;
}
// first call to quick sort
let sortedArray = quickSort(items, 0, items.length - 1);
console.log(sortedArray); //prints [2,3,5,6,7,9]

////////////////////////////////////////////////////////////////////////////////////////////////
// *Consider: Where will the recursive call be? When do we know a portion of the array has been sorted? When do we know the entire array has been sorted?

/*
?Recursive Approach:
    !1: If size of array is zero or one, return true.
    !2: Check last two elements of array, if they are
        !sorted, perform a recursive call with n-1
        !else, return false.
!If all the elements will be found sorted, n will
!eventually fall to one, satisfying Step 1.
*/
    //?I think it's when i and j are at the same position in the array. 
    //?And it can't work any further.
////////////////////////////////////////////////////////////////////////////////////////////////
/*
Bonus 1:  Different strategies are used to choose the pivot. Any pivot would work, so why not just choose an easy pivot, such as the left-most value? The answer is that the time complexity could be greatly increased if we were to call quicksort on an array that is already sorted. Diagram this out and determine why this is true.
*/
    /*
    [1,2,3,4,5]
        if we choose the middle (3) and we want variable i to review the left side and j review the right side of the pivot (array[2])
        function will still go through process of checking when it's not really necessary when you know the array is sorted.
    */
////////////////////////////////////////////////////////////////////////////////////////////////
/*
Bonus 2:  What is the Big O time complexity of this algorithm?

O(log(N)) -> Quick Sort
    Algorithms that can employ a divide and conquer approach.
*/

////////////////////////////////////////////////////////////////////////////////////////////////
/*
Bonus 3:  The Big O time complexity of quicksort is actually not impressive at all. So why is it called quicksort? Remember that Big O is for the worst case scenario. In this case, the worst case scenario is unlikely to be encountered - it's when we try to quicksort a sorted array and assign the pivot to an edge value. We use Big Omega to talk about the best case scenario and Big Theta to talk about the average case.  What are the Big Omega and Big Theta time complexities of quicksort?
*/

    /*
    O(N) is the best case scenario which is what Big Omega is
        It is like (>=) 
        rate of growth is greater than or equal to a specified value.

    O(N*log(N)) is the average case scenario which is what Big Theta is
        It is like (==) 
        meaning the rate of growth is equal to a specified value.

    0 <= f(n) <= Cg(n) for all n >= n0
        n = used to give upper bound an a function. 
        If a function is O(n), it is automatically O(n-square) as well. 
    */
