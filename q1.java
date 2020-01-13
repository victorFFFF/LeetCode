
    public static List<String> groupTransactions(List<String> transactions) {
    // Write your code here

        java.util.Collections.sort(transactions);

        HashMap<String, Integer> hMap = new HashMap<>();
        LinkedList<String> uniqueStrings  = new LinkedList <>();

        //Count # of transaction
        for(int i = 0; i < transactions.size(); i++)
        {
            if( hMap.get(transactions.get(i)) == null)
            {
                hMap.put(transactions.get(i), 1);
                uniqueStrings.add(transactions.get(i));
            }
            else
                hMap.put(transactions.get(i), hMap.get( transactions.get(i)) + 1);
        }

        //construct new list
        List<String> newList = new ArrayList<>();

        for(int i = 0; i < hMap.size(); i++)
            {
                newList.add(uniqueStrings.getFirst() + " " + hMap.get(uniqueStrings.getFirst()));
                uniqueStrings.removeFirst();
            }

        return newList;
    }
