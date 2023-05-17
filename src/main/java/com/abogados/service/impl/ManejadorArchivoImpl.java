package com.abogados.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.abogados.exception.ExcepcionArgumento;
import com.abogados.util.ConexionS3;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.service.IManejadorArchivo;

@Service
public class ManejadorArchivoImpl implements IManejadorArchivo {

    @Value("${ruta}")
    private String rutaArchivo;

    private final ConexionS3 conexionS3;

    public ManejadorArchivoImpl(ConexionS3 conexionS3) {
        this.conexionS3 = conexionS3;
    }

    @Override
    public String guardarArchivo(MultipartFile archivoLlegada, String subRuta)
            throws IllegalStateException, IOException {

        if (archivoLlegada.getOriginalFilename() == null)
            throw new ExcepcionArgumento("ARCHIVO' NO VALIDO");
        String nombreArchivo = subRuta + "/" + crearNombreArchivo(archivoLlegada.getOriginalFilename());

        boolean resultado = convertirYGuardar(nombreArchivo, archivoLlegada);

        if (!resultado)
            throw new ExcepcionArgumento("Fallo en la subida del Archivo");

        return nombreArchivo;
    }

    private boolean convertirYGuardar(String nombreArchivo, MultipartFile archivoLlegada) throws IOException {

        File archivoSubida = new File(archivoLlegada.getOriginalFilename());
        FileUtils.writeByteArrayToFile(archivoSubida, archivoLlegada.getBytes());

        return conexionS3.subir(nombreArchivo, archivoSubida);
    }

    @Override
    public String actualizarArchivo(MultipartFile archivoLlegada, String nombreArchivoAntiguo, String subRuta)
            throws IllegalStateException, IOException {

        eliminarArchivo(nombreArchivoAntiguo);

        return guardarArchivo(archivoLlegada, subRuta);
    }

    public void eliminarArchivo(String archivoEliminado)
            throws IllegalStateException, IOException {
        conexionS3.elimiar(archivoEliminado);
    }

    private String crearNombreArchivo(String nombreArchivo) {

        int numero = (int) (Math.random() * 200 + 1);
        return "archivo-" + numero + "-" + (nombreArchivo.replace("\\", ""));
    }

    @Override
    public byte[] obtenerArchivo(String subRuta, String nombreArchivo) throws IOException {
        return conexionS3.obtenerArchivo(nombreArchivo);
    }

}
