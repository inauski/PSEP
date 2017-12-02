import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;

public class Globo
{
	private int x;
	private int y;
	private ImageIcon imagen;
	
	public Globo(int x, int y)
	{
		 this.x = x;
		 this.y = y;
		 URL url = getClass().getResource("/images/globo.png");
		 imagen = new ImageIcon(url);
		 
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public ImageIcon getImagen()
	{
		return imagen;
	}

	public void dibujar(Graphics g)
	{
	//	 g.drawImage(imagen, x, y, null);
		 imagen.paintIcon(null, g, x, y);
	}

	@Override
	public String toString()
	{
		return "Globo [x=" + x + ", y=" + y + "]";
	}
	
	

}
