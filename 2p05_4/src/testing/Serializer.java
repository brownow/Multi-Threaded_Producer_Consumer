/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	public void saveBuffer (BoundedBuffer bb, String file) throws IOException{
		FileOutputStream fostream = new FileOutputStream(file);
		BufferedOutputStream bostream = new BufferedOutputStream(fostream);
		ObjectOutputStream oostream = new ObjectOutputStream(bostream);
		oostream.writeObject(bb);
		oostream.close();
	}
	
	public BoundedBuffer loadBuffer(String file) throws IOException, ClassNotFoundException {
		FileInputStream fistream = new FileInputStream(file);
        BufferedInputStream bistream = new BufferedInputStream(fistream);
        ObjectInputStream oistream = new ObjectInputStream(bistream);
        BoundedBuffer bb = (BoundedBuffer)oistream.readObject();
        oistream.close();
        return bb;
	}
	
}
