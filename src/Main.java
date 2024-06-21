import java.util.Scanner;

class Node
{
    int data;
    Node sag;
    Node sol;

    Node(int data)
    {
        this.data = data;
        this.sag = null;
        this.sol = null;
    }
}

class BTree
{
    Node kok;

    BTree()
    {
        this.kok = null;
    }

    Node Ekle(Node kok, int data)
    {
        if (kok == null)
        {
            this.kok = new Node(data);
            return this.kok;
        }

        if (data < kok.data)
        {
            kok.sol = Ekle(kok.sol, data);
        } else if (data > kok.data)
        {
            kok.sag = Ekle(kok.sag, data);
        }
        return kok;
    }

    public void inorder(Node kok)
    {
        if (kok != null)
        {
            inorder(kok.sol);
            System.out.print(kok.data + " ");
            inorder(kok.sag);
        }
    }

    public void preorder(Node kok)
    {
        if (kok != null)
        {
            System.out.print(kok.data + " ");
            preorder(kok.sol);
            preorder(kok.sag);
        }
    }

    public void postorder(Node kok)
    {
        if (kok != null)
        {
            postorder(kok.sol);
            postorder(kok.sag);
            System.out.print(kok.data + " ");
        }
    }

    public void arama(Node kok, int data)
    {
        boolean ara = false;
        while (kok != null)
        {
            System.out.println(kok.data + " ");
            if (data == kok.data)
            {
                ara = true;
                break;
            } else if (data < kok.data)
            {
                kok = kok.sol;
            } else //(data> kok.data)
            {
                kok = kok.sag;
            }
        }

        if (ara)
        {
            System.out.println("Eleman Bulundu.");
        } else
        {
            System.out.println("Eleman Bulunmadı.");
        }
    }

    Node BTmin(Node kok)
    {
        if (kok == null) {
            return null;
        }
        while (kok.sol != null)
        {
            kok = kok.sol;
        }
        return kok;
    }

    Node BTmax(Node kok)
    {
        if (kok == null) {
            return null;
        }
        while (kok.sag != null)
        {
            kok = kok.sag;
        }
        return kok;
    }

    static void print2D(Node root)
    {
        print(root, 0);
    }

    public static void print(Node kok, int uzunluk)
    {

        if (kok == null)
            return;

        print(kok.sag, uzunluk+1);
        if(uzunluk!=0)
        {
            for(int i =0;i<uzunluk-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+ kok.data);
        }
        else
            System.out.println(kok.data);
        print(kok.sol, uzunluk+1);
    }
}


public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BTree btree = new BTree();

        while (true)
        {
            System.out.println("2212102064-Barış Tok-vyaFinalProjesi");
            System.out.println("1) Eleman Ekle");
            System.out.println("2) Arama");
            System.out.println("3) Min Bul");
            System.out.println("4) Max Bul");
            System.out.println("5) PreOrder");
            System.out.println("6) InOrder");
            System.out.println("7) PostOrder");
            System.out.println("0) Çıkış");

            System.out.println("2212102064-Barış Tok-vyaFinalProjesi");
            int secim = sc.nextInt();

            int data;
            switch (secim)
            {
                case 1:
                    while (true) {
                        System.out.println("Eklenecek Değeri Girin (Çıkış için -1 yazın): ");
                        data = sc.nextInt();
                        if (data == -1) {
                            break;
                        }
                        btree.kok = btree.Ekle(btree.kok, data);
                    }
                    break;
                case 2:
                    System.out.println("Aranacak Sayıyı Girin: ");
                    data = sc.nextInt();
                    System.out.println("Arama Yolu:");
                    btree.arama(btree.kok, data);
                    break;
                case 3:
                    Node min = btree.BTmin(btree.kok);
                    if (min != null)
                    {
                        System.out.println("Min Değer: " + min.data);
                    } else
                        System.out.println("Ağaç Boş");
                    break;
                case 4:
                    Node max = btree.BTmax(btree.kok);
                    if (max != null)
                    {
                        System.out.println("Max Değer: " + max.data);
                    } else
                        System.out.println("Ağaç Boş");
                    break;
                case 5:
                    System.out.println("PreOrder: ");
                    btree.preorder(btree.kok);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("InOrder: ");
                    btree.inorder(btree.kok);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("PostOrder: ");
                    btree.postorder(btree.kok);
                    System.out.println();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Geçersiz Seçim");
            }
            BTree.print2D(btree.kok);
        }
    }
}