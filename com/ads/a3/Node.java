package com.ads.a3;

class Node
{
    int value;
    int height;
    Node left;
    Node right;

    public Node(int value)
    {
        this.value = value;
        this.height = 0; // Initial height is set to 0
        this.left = null;
        this.right = null;
    }

}