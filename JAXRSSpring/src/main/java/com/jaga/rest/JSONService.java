package com.jaga.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaga.pojo.Track;
 
@Component
@Path("/json/metallica")
public class JSONService {
 
	@Autowired
	Track track;
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {
 
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
 
		return track;
 
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
 
		String result = "Track saved : " + track;
		
		System.out.println("singer:"+track.getSinger());
		System.out.println("title:"+track.getTitle());
		return Response.status(201).entity(result).build();
 
	}
 
}
