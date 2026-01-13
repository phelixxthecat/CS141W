class Shape
{
	String name;
	Shape(String newName)
	{
		name = newName;
	}

	void print()
	{
		System.out.print(name);
		System.out.print(" ( ");
		System.out.print(" ) ");
		System.out.print(" : ");
		System.out.print(Double.toString(area()));
	}

	double area()
	{
		return -1.0;
	}

	void draw()
	{
		System.out.println("Shape.draw()");
	}

}

class Circle extends Shape
{
	int radius;
	
	Circle(String name, int r)
	{
		super(name);
		radius = r;
	}

	double area()
	{
		return(Math.PI * radius * radius);
	}

	void draw()
	{
		System.out.println("  ***  ");
		System.out.println(" *   * ");
		System.out.println("  ***  ");
	}

	void print()
	{
		System.out.printf("%s(%d) : %.2f%n", name, radius, area());
	}
}

class Square extends Shape
{
	int length;

	Square(String name, int l)
	{
		super(name);
		length = l;
	}

	double area()
	{
		return length * length;
	}

	void draw()
	{
		System.out.println(" **** ");
		System.out.println(" *  * ");
		System.out.println(" **** ");
	}

	void print()
	{
		System.out.printf("%s(%d) : %.2f%n", name, length, area());
	}
}

class Triangle extends Shape
{
	int height, base;

	Triangle(String name, int b, int h)
	{
		super(name);
		base = b;
		height = h;
	}

	double area()
	{
		return base * height * 0.5;
	}

	void draw()
	{
		System.out.println("    *  ");
		System.out.println("   * *  ");
		System.out.println("  *   *  ");
		System.out.println(" ******* ");
	}

	void print()
	{
		System.out.printf("%s(%d, %d) : %.2f%n", name, base, height, area());
	}
}

class Rectangle extends Square
{
	int width;

	Rectangle(String name, int l, int w)
	{
		super(name, l);
		width = w;
	}

	double area()
	{
		return length * width;
	}

	void draw()
	{
		System.out.println(" *****  ");
		System.out.println(" *   *  ");
		System.out.println(" *   *  ");
		System.out.println(" ***** ");
	}

	void print()
	{
		System.out.printf("%s(%d, %d) : %.2f%n", name, length, width, area());
	}
}


class ListNode
{
	Shape data;
	ListNode next;

	ListNode(Shape s)
	{
		data = s;
		next = null;
	}
}

class Picture
{
	ListNode head;

	Picture()
	{
		head = null;
	}
	
	void add(Shape sh)
	{
		ListNode newNode = new ListNode(sh);
		newNode.next = head;
		head = newNode;
	}

	void printAll()
	{
		for(ListNode p = head; p != null; p = p.next)
		{
			p.data.print();
		}
	}

	void drawAll()
	{
		for(ListNode  p = head; p != null; p = p.next)
		{
			p.data.draw();
		}
	}

	double totalArea()
	{
		double total = 0.0;

		for(ListNode  p = head; p != null; p = p.next)
		{
			total += p.data.area();
		}
		
		return total;
	}
}

public class mainClass
{
	public static void main(String[] args)	{
	if (args.length < 2) 
	{
		System.out.println("Usage: java mainClass <arg1> <arg2>");
		return;
	}
		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);

		Picture pic = new Picture();
		
		pic.add(new Triangle("SecondTriangle", arg1 - 1, arg2 - 1));
		pic.add(new Triangle("FirstTriangle", arg1, arg2));

		pic.add(new Circle("SecondCircle", arg1 - 1));
		pic.add(new Circle("FirstCircle", arg1));

		pic.add(new Square("SecondSquare", arg1 - 1));
		pic.add(new Square("FirstSquare", arg1));

		pic.add(new Rectangle("SecondRectangle", arg1 - 1, arg2 - 1));
		pic.add(new Rectangle("FirstRectangle", arg1, arg2));

		pic.printAll();
		pic.drawAll();

		System.out.printf("Total : %.2f%n", pic.totalArea());
	}
}

