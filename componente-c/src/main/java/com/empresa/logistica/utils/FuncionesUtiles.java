package com.empresa.logistica.utils;

import java.util.List;
import java.util.UUID;

public class FuncionesUtiles {

    // Método para calcular el total de una lista de precios o montos
    public static double calcularTotal(List<Double> valores) {
        if (valores == null || valores.isEmpty()) return 0;
        return valores.stream().mapToDouble(Double::doubleValue).sum();
    }

    // Método para generar un código único por tipo de entidad
    public static String generarCodigoUnico(String tipoEntidad) {
        return tipoEntidad.toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
