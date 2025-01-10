def call(String status, String recipients) {
    emailext(
        // Asunto del correo (subject)
        subject: "Build ${status}: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        
        // Cuerpo del correo (body)
        body: """
            <p>El build ha terminado con el estado: <b>${status}</b>.</p>
            <p>Detalles:</p>
            <ul>
                <li><b>Job:</b> ${env.JOB_NAME}</li> <!-- Nombre del Job en Jenkins -->
                <li><b>Build Number:</b> ${env.BUILD_NUMBER}</li> <!-- Número de build actual -->
                <li><b>Estado:</b> ${status}</li> <!-- Estado del build (ej: SUCCESS, FAIL) -->
                <li><b>URL del Build:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></li> <!-- URL del build en Jenkins -->
            </ul>
        """,
        
        // Destinatarios del correo (to)
        to: recipients,
        
        // Tipo de contenido del correo (mimeType)
        mimeType: 'text/html'
    )
}
