// enter/spaceでもクリックと同処理
document.querySelectorAll("button").forEach(button => {
    button.addEventListener("click", () => {
        // console.log(`ボタン「${button.textContent}」がクリックされました！`);
    });

    button.addEventListener("keydown", (event) => {
        if (event.key === "Enter" || event.key === " ") {
            event.preventDefault();
            button.click();
        }
    });
});

// 記録ボタンを押してスコアをsendScoresに送る
document.getElementById("record")?.addEventListener("click", function() {
    const userName = document.getElementById("user_name")?.value;
    const score = document.getElementById("score")?.value;
    console.log(`data sending... ${userName}:${score}`)

    if (userName.trim() === "" || score.trim() === "") {
        alert("ユーザーネームとスコアを入力してください！");
        return;
    }
    // const newEntry = { user_name: userName, score: Number(score) };
    sendScores(userName,score);
});

// userName,scoreをpostする
function sendScores(user: string,score: string) {
    fetch('http://localhost:5000/pgset', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ user: user, score: score })
    })
    .then(() => {
        console.log("Data transmission was successful");
        displayScores;
    })
    .catch(() => console.log("Data transmission failed "))
}

function displayScores() {
    fetch('http://localhost:5000/pgget')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("score_table"); // tbody の要素を取得
            tableBody.innerHTML = ""; // 初期化（既存のデータをクリア）

            data.forEach(item => { // データを繰り返し処理
                const row = document.createElement("tr"); // 新しい行を作成

                const userNameCell = document.createElement("td");
                userNameCell.textContent = item.USER_NAME; // ユーザーネームをセルに追加

                const scoreCell = document.createElement("td");
                scoreCell.textContent = item.SCORE; // スコアをセルに追加

                row.appendChild(userNameCell);
                row.appendChild(scoreCell);
                tableBody.appendChild(row); // テーブルに行を追加
            });
        })
    console.log("Display was successful");
}

// ページ読み込み時にスコア一覧を表示
window.onload = displayScores;