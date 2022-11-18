/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializablePersona;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author alumnotd
 */
public class ClaseOutput extends ObjectOutputStream{
    
    ClaseOutput(FileOutputStream f) throws IOException{
        super(f);
    }
    @Override
    protected void writeStreamHeader(){}
}