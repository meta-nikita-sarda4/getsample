package shopping;

import java.util.*;

class item { // item class for description of items
	private
	int id;
	String name;
	Double price;

	item(int id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getid() // will return id of item
	{
		return id;
	}

	public String getname() // will return name of item
	{
		return name;
	}

	public Double getprice() // will return price of item
	{
		return price;
	}
}

class cart { // cart class for cart's description
	private
	int count;
	HashMap<item, Integer> hitem = new HashMap<item, Integer>();

	cart() {
		count = 0;
	}

	public void showcart() // this will show cart details
	{
		if (count == 0)
			System.out.println("Cart is Empty");
		else {
			double cart_total = 0.0;
			System.out.println("Item_Id   Item_Name   Item_Price   Quantity");
			for (Map.Entry m : hitem.entrySet()) {
				item i = (item) m.getKey();
				// int q = (int)m.getValue();
				System.out.println(i.getid() + "         " + i.getname()
						+ "        " + i.getprice() + "   " + "      "
						+ m.getValue());
				cart_total = cart_total + ((int) m.getValue() * (i.getprice()));
			}
			System.out.println("Your cart's total amount is: " + cart_total);
		}
	}

	public void additem(item i) // to add new item in cart
	{
		// boolean flag = false;
		if (hitem.containsKey(i)) {
			int j = (int) hitem.get(i) + 1;
			hitem.put(i, j);
			// flag=true;
		} else {
			hitem.put(i, 1);
			count++;
		}

	}

	public void removeitem(item i) // to remove an item from cart
	{
		if (hitem.containsKey(i)) {
			int j = hitem.get(i);
			if (j == 1) {
				hitem.remove(i);
				count--;
			} else
				hitem.put(i, j - 1);
		} else {
			System.out.println("this item doesn't exist in your cart");
		}
	}

}

public class assign_1 {
	public static Scanner sc = new Scanner(System.in);

	public static void showlist(List items) // this will show list of all items
											// available
	{
		System.out.println("Item_Id   Item_Name   Item_Price");
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			item i = (item) itr.next();
			System.out.println(i.getid() + "         " + i.getname()
					+ "        " + i.getprice());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<item> itemlist = new ArrayList<item>();
		itemlist.add(new item(1, "book1", 100.0));
		itemlist.add(new item(2, "book2", 200.0));
		itemlist.add(new item(3, "book3", 300.0));
		itemlist.add(new item(4, "book4", 400.0));
		itemlist.add(new item(5, "book5", 500.0));
		cart c = new cart();
		try {
			while (1 == 1) {
				System.out.println("enter 1: to view itemlist "
						+ "2: to view your cart" + "3:to add element "
						+ "4:to remove element " + "0: to exit");
				int i = sc.nextInt();
				if (i == 0)
					break;
				int id;
				switch (i) {
				case 1: // to show list of all items available
					showlist(itemlist);
					break;
				case 2: // to show items already in cart
					c.showcart();
					break;
				case 3: // to add new item in cart
					System.out.println("Enter your item id");
					id = sc.nextInt();
					boolean flag = false;
					Iterator itr = itemlist.iterator();
					while (itr.hasNext()) {
						item it = (item) itr.next();
						if (it.getid() == id) {
							flag = true;
							c.additem(it);
							break;
						}
					}
					if (flag == false) {
						System.out.println("Such item is not in list");
					}
					break;

				case 4: // to remove existing item from cart
					System.out.println("Enter item id to remove");
					id = sc.nextInt();
					boolean flag1 = false;
					Iterator itr1 = itemlist.iterator();
					while (itr1.hasNext()) {
						item it1 = (item) itr1.next();

						if (it1.getid() == id) {
							flag1 = true;
							c.removeitem(it1);
							break;
						}
					}
					if (flag1 == false)
						System.out
								.println("This item doesn't exist in your cart");
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Some unwanted Error occured: " + e);
		}

	}

}
