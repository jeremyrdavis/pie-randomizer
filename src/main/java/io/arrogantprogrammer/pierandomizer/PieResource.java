package io.arrogantprogrammer.pierandomizer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/")
public class PieResource {

    List<String> vegList = new ArrayList<String>(){{
        add("cabbage");
        add("onion");
        add("leek");
        add("potato");
        add("butternut squash");
        add("mushroom");
        add("carrots");
        add("peas");
    }};

    List<String> proteinList = new ArrayList<>(){{
        add("steak");
        add("steak and ale");
        add("fish");
        add("chorizo");
        add("paneer");
    }};

    List<String> fillingList = new ArrayList<>(){{
        add("ale");
        add("stilton");
        add("cream");
        add("curry");
    }};

    @GET
    @Path("/pie")
    public Response pie() {

        Random random = new Random();
        String pie = String.format("%s and %s with %s pie",
                proteinList.get(random.nextInt(proteinList.size() -1)),
                vegList.get(random.nextInt(vegList.size() -1)),
                fillingList.get(random.nextInt(fillingList.size() -1)));

        return Response.ok().entity(pie).build();
    }

    @GET
    @Path("/veg")
    public Response allVeg() {

        return Response.ok().entity(vegList).build();
    }

    @GET
    @Path("/protein")
    public Response allProteins() {
        return Response.ok().entity(proteinList).build();

    }

    @GET
    @Path("/filling")
    public Response allFillings() {
        return Response.ok().entity(fillingList).build();

    }
}
