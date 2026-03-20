from fastapi import FastAPI, File, UploadFile

app = FastAPI()

@app.post("/predict")
async def predict(file: UploadFile = File(...)):
    content = await file.read()
    
    return {
        "filename": file.filename,
        "size": len(content)
    }