package pojos;

public class DummyRestApiResponseBodyPojo {
    //{
    //                        "status": "success",
    //                        "data": {
    //                            "employee_name": "Ali Can",
    //                            "employee_salary": 111111,
    //                            "employee_age": 23,
    //                            "profile_image": "Perfect image"
    //                        },
    //                        "message": "Successfully! Record has been updated."
    //                    }

    private String status;
    private DummyRestApiDataPojo data;
    private String message;

    public DummyRestApiResponseBodyPojo() { //conersation kurmak icin bos bir constructor'a ightiyacimiz var yoksa okumuyor
    }

    public DummyRestApiResponseBodyPojo(String status, DummyRestApiDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiDataPojo getData() {
        return data;
    }

    public void setData(DummyRestApiDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiResponseBodyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}


