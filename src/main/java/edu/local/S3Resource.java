package edu.local;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;

@Path("/s3resource")
public class S3Resource {

    @Inject
    S3Service s3Service;

    // Endpoint para upload de arquivos
    @POST
    @Path("/upload/{key}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response uploadFile(@PathParam("key") String key, InputStream fileInputStream) {
        try {
            s3Service.uploadFile(key, fileInputStream);
            return Response.ok("File uploaded successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("File upload failed: " + e.getMessage()).build();
        }
    }

    // Endpoint para download de arquivos
    @GET
    @Path("/download/{key}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("key") String key) {
        try {
            InputStream fileStream = s3Service.downloadFile(key);
            return Response.ok(fileStream).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("File not found: " + e.getMessage()).build();
        }
    }

    // Endpoint para deletar arquivos
    @DELETE
    @Path("/delete/{key}")
    public Response deleteFile(@PathParam("key") String key) {
        try {
            s3Service.deleteFile(key);
            return Response.ok("File deleted successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("File deletion failed: " + e.getMessage()).build();
        }
    }
}
