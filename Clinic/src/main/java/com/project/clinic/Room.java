package com.project.clinic;

import jakarta.persistence.*;

@Entity
public class Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private int roomNumber;

    @ManyToOne
    private Clinic clinic;
    @Column(length = 50)
    private String type;
    private enum Status
    {
        BUSY, FREE
    }
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Room(){};

    public Room(Clinic clinic, String type, Status status)
    {
        this.clinic = clinic;
        this.type = type;
        this.status = Status.FREE;
    }

    public void setStatus(String s)
    {
        if(s.equalsIgnoreCase("FREE"))
        {
            this.status = Status.FREE;
        } else if (s.equalsIgnoreCase("BUSY")) {
            this.status = Status.BUSY;
        }

    }

    public int getRoomId()
    {
        return roomId;
    }

    public void setRoomId(int roomId)
    {
        this.roomId = roomId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}
