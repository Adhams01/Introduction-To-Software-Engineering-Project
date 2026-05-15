$ErrorActionPreference = 'Stop'

$root = Join-Path $PSScriptRoot 'src'
if (-not (Test-Path $root)) {
  throw "src folder not found: $root"
}

$fixedUtf8 = 0
$fixedUtf16 = 0

Get-ChildItem -Path $root -Recurse -Filter '*.java' | ForEach-Object {
  $path = $_.FullName
  $bytes = [System.IO.File]::ReadAllBytes($path)

  if ($bytes.Length -ge 3 -and $bytes[0] -eq 0xEF -and $bytes[1] -eq 0xBB -and $bytes[2] -eq 0xBF) {
    $newBytes = $bytes[3..($bytes.Length - 1)]
    [System.IO.File]::WriteAllBytes($path, $newBytes)
    $fixedUtf8++
    return
  }

  if ($bytes.Length -ge 2 -and $bytes[0] -eq 0xFF -and $bytes[1] -eq 0xFE) {
    $newBytes = $bytes[2..($bytes.Length - 1)]
    [System.IO.File]::WriteAllBytes($path, $newBytes)
    $fixedUtf16++
    return
  }
}

Write-Host "Removed UTF-8 BOM from $fixedUtf8 .java files."
Write-Host "Removed UTF-16 BOM from $fixedUtf16 .java files."
