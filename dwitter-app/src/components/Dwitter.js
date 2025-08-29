import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";
import axios from "axios";

export default function Dwitter(props) {
  function handleDelete(id) {
    // alert(id);
    //axios => 스프링부트의 삭제 로직 호출!!
    const data = { id: id };
    axios
      .post("http://localhost:8080/api/dwitters/delete", data)
      .then((response) => {
        if (response.data === "ok") {
          // alert("삭제가 완료되었습니다");
          props.onSuccessDelete();
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="dwitter">
      <div className="image">
        <img src={props.image} />
      </div>
      <div className="dwitter-sub">
        <div className="title">
          <div className="profile">
            <span>{props.name}</span>
            <span>@{props.id}</span>
            <span>{props.date}</span>
            <div className="profile-trash">
              <FontAwesomeIcon
                icon={faTrash}
                className="trash"
                onClick={() => handleDelete(props.id)}
              />
            </div>
          </div>
          <div className="content">{props.message}</div>
        </div>
      </div>
    </div>
  );
}
