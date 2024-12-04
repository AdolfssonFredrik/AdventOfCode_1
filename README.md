# :santa:  Advent Of Code Day 1 :santa:

---

# :snowflake: Introduction :snowflake:



 This is my solution to part one and part two of the advent of code day 1 problem. The solution is built upon a binary tree for sorting a searching the lists.

 
[Advent Of Code Day 1](https://adventofcode.com/2024/day/1)


# :robot: Method Explaination :robot:

- ### parseFile(String filePath)
    This method is responsible for reading and parsing the input file. It also splits the input into two ArrayLists.
---
    public void parseFile(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));

        String line;

        StringTokenizer st;

        int counter = 0;

        while((line = br.readLine()) != null){
            st = new StringTokenizer(line, " ");

            leftList.add(Integer.parseInt(st.nextToken()));
            rightList.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
    }
---



- ### insertRec(Node root, int value)
    This method adds new values to the tree. The method also deals with there being multiples of the same node by having a variable called amount for each node.
---

    public Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value, 1);
        }
        if(value < root.value) {
            root.left = insertRec(root.left, value);
        }
        else if(value > root.value) {
            root.right = insertRec(root.right, value);
        }
        else{
            root.amount = root.amount + 1;
        }
        return root;
    }
---

- ### getSortedList(Node root)
    This method is responsible for turning the trees into arraylists. It also conciders the case of there being multiples of the same value in a node.

--- 

    public ArrayList<Integer> getSortedList(Node root) {
        if (root != null) {
            getSortedList(root.left);
            for(int i = 0; i < root.amount; i++) {
                sortedList.add(root.value);
            }
            getSortedList(root.right);
        }
        return sortedList;
    }

---


- ### search(int value, Node root)
    This method is responsible for searching through a tree to find a specific node with the given value.
---

    public Node search(int value, Node root) {
        if(root != null) {
            if (root.value == value) {
                //if value is found in tree 
                //return the node where it is found
                return root;
            } else if (value < root.value) {
                return search(value, root.left);
            } else {
                return search(value, root.right);
            }
        }else{
            //Return null if node not found
            return null;
        }
    }

---

- ### getDifference(ArrayList<Integer> sortedLeft, ArrayList<Integer> sortedRight)
    This method is repsonsible for finding the total distance between to given lists. This is the solution to part one of the problem.

---
    public static void getDifference(ArrayList<Integer> sortedLeft, ArrayList<Integer> sortedRight) {
        for(int i = 0; i < sortedRight.size(); i++){
            int a = sortedLeft.get(i) - sortedRight.get(i);
            difference += (a < 0) ? -a : a;
        }
        System.out.println("The difference is: " + difference);
    }
---

- ### getSimilarityScore(ArrayList<Integer> sortedLeft, Tree rightTree)
    This method is responsible for finding how similar two lists are. The smaller the number the more similar the lists are. This is the solution for part two.

---
    public static void getSimilarityScore(ArrayList<Integer> sortedLeft, Tree rightTree) {
        int sum = 0;

        for(int number : sortedLeft){
            Node searchIndex = rightTree.search(number, rightTree.root);
            if(searchIndex != null){
                count = searchIndex.amount;
                product = count * number;
                sum += product;
            }
        }
        System.out.println("The similarity score is: " + sum);
    }
---