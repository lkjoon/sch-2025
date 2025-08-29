import { useState, useEffect } from "react";
import axios from "axios";

export default function DwitterForm(props) {
  const [name, setName] = useState("");
  const [message, setMessage] = useState("");

  function handleRegister() {
    //axios => 스프링부트의 등록 로직 호출!!
    const data = {
      name: name,
      message: message,
      image:
        // "https://images.unsplash.com/photo-1617624863198-0e4323b6e968?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8ODN8fCVFQyU5NSVCQyVFQyU5OSVCOHxlbnwwfHwwfHx8MA%3D%3D",
        "https://images.unsplash.com/photo-1500964757637-c85e8a162699?q=80&w=2103&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    };
    axios
      .post("http://localhost:8080/api/dwitters/register", data)
      .then((response) => {
        console.log(response.data);
        if (response.data !== "") {
          //   alert("등록이 완료되었습니다");
          props.onSuccess();
          setName("");
          setMessage("");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="dwitter-form">
      <form>
        <div className="dwitter-sub-form">
          {/* <label htmlFor="name">이름</label> */}
          <input
            className="name"
            type="text"
            id="name"
            name="name"
            value={name}
            placeholder="이름을 입력하세요"
            onChange={(e) => {
              setName(e.target.value);
            }}
          />
          <input
            className="message"
            type="text"
            id="name"
            name="name"
            value={message}
            placeholder="메시지를 입력하세요"
            onChange={(e) => {
              setMessage(e.target.value);
            }}
          />
          <button
            type="button"
            className="btn-register"
            onClick={handleRegister}
          >
            등록하기
          </button>
        </div>
      </form>
    </div>
  );
}
