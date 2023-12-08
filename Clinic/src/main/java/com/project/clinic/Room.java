package com.project.clinic;

public class Room
{
    private int roomId;
    private int clinicId;//czy napewno clinicId??
    private String type;
    private enum status
    {
        BUSY, FREE
    }

    public int getRoomId()
    {
        return roomId;
    }

    public void setRoomId(int roomId)
    {
        this.roomId = roomId;
    }

    public int getClinicId()
    {
        return clinicId;
    }

    public void setClinicId(int clinicId)
    {
        this.clinicId = clinicId;
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
